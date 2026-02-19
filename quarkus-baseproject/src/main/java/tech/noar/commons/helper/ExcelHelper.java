package tech.noar.commons.helper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wildfly.common.Assert;
import tech.noar.commons.ServiceException;
import tech.noar.commons.enums.ExcelVersion;
import tech.noar.commons.enums.responseCode.CommonResponseCode;
import tech.noar.commons.generator.ExcelGenerator;

import java.io.ByteArrayOutputStream;
import java.util.List;

public class ExcelHelper {
    private static final Logger log = LoggerFactory.getLogger(ExcelHelper.class);

    public static <T> byte[] writeToExcelAsBytes(List<T> data, Class<T> clazz, ExcelVersion excelVersion, boolean headerFromData) {
        Assert.checkNotNullParam("data", data);
        Assert.checkNotNullParam("clazz", clazz);
        Assert.checkNotNullParam("excelVersion", excelVersion);

        try (ExcelGenerator excelGenerator = new ExcelGenerator(excelVersion, headerFromData)) {
            excelGenerator.createSheet(data, clazz);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            excelGenerator.write(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            log.error("writeToExcelAsBytes: Error while generate excel {} : {} - {}", new Object[] { clazz.getName(), e.getMessage(), e });
            throw new ServiceException(CommonResponseCode.GENERATE_EXCEL_FAILED);
        }
    }
}

