package tech.noar.configurations;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.model.relational.ColumnOrderingStrategy;
import org.hibernate.boot.model.relational.ColumnOrderingStrategyStandard;
import org.hibernate.mapping.*;
import org.jboss.logging.Logger;

import java.lang.reflect.Field;
import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hibernate.cfg.MappingSettings.COLUMN_ORDERING_STRATEGY;

@ApplicationScoped
@Priority(1)
public class CustomColumnOrderingStrategy extends ColumnOrderingStrategyStandard implements ColumnOrderingStrategy {

    public static final CustomColumnOrderingStrategy INSTANCE = new CustomColumnOrderingStrategy();

    private static final Logger logger = Logger.getLogger(CustomColumnOrderingStrategy.class);

    private static final Map<String, String> configuration = new HashMap<>();

    static {
        configuration.put(COLUMN_ORDERING_STRATEGY, "CustomColumnOrderingStrategy");
    }

    @Override
    public List<Column> orderTableColumns(Table table, Metadata metadata) {
        logger.infof("table %s", table.getName());

        final PersistentClass persistentClass = metadata.getEntityBindings().stream()
                .filter(a -> a.getTable().equals(table)).findFirst()
                .orElse(null);

        if (persistentClass == null) {
            return table.getColumns().stream().toList();
        }

        LinkedHashSet<Column> sortedColumns = new LinkedHashSet<>();

        //put identifier property at first
        final Property identifierProperty = persistentClass.getIdentifierProperty();
        if (identifierProperty != null) {
            sortedColumns.addAll(identifierProperty.getColumns());
        }

        final Class<?> mappedClass = persistentClass.getMappedClass();
        final List<Field> classFields = Arrays.stream(mappedClass.getDeclaredFields())
                .filter(a -> !a.getName().contains("$$_"))
                .toList();

        if (!classFields.isEmpty()) {
            final List<Property> properties = persistentClass.getProperties().stream()
                    .filter(a -> classFields.stream()
                            .anyMatch(b -> b.getName().equals(a.getName())))
                    .toList();
            properties.forEach(property -> sortedColumns.addAll(property.getColumns()));
        }

        MappedSuperclass mappedSuperClass = persistentClass.getSuperMappedSuperclass();

        while (mappedSuperClass != null) {
            mappedSuperClass.getDeclaredProperties().forEach(property -> sortedColumns.addAll(property.getColumns()));
            mappedSuperClass = mappedSuperClass.getSuperMappedSuperclass();
        }

        return sortedColumns.stream().toList();
    }

}
