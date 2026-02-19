package tech.noar.commons;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import org.apache.commons.lang3.ArrayUtils;
import tech.noar.commons.models.Pageable;
import tech.noar.commons.models.PaginationResult;

import java.util.List;

public interface PaginationRepository<T, K> extends PanacheRepositoryBase<T, K> {

    // TODO: return Uni<Pagination<T>>
    default Uni<PaginationResult<T>> findAll(String query, Pageable pageable, Object... params) {

        int page = 0;
        int pageSize = 10;
        Sort sort = Sort.empty();

        if (pageable != null) {
            page = pageable.page;
            pageSize = pageable.pageSize;
            sort = pageable.sort;
        }

        PanacheQuery<T> panacheQuery;
        if (ArrayUtils.isEmpty(params)) {
            panacheQuery = findAll();
        } else {
            panacheQuery = find(query, sort, params);
        }

        panacheQuery.page((page > 0 ? page - 1 : page), pageSize);
        final Uni<List<T>> result = panacheQuery.list();

        return Uni.createFrom().item(new PaginationResult<>());
    }

}
