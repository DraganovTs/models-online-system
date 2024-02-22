package com.models.online.system.download.service.domain;

import com.models.online.system.domain.valueobject.*;
import com.models.online.system.download.service.domain.dto.create.CreateDownloadCommand;
import com.models.online.system.download.service.domain.dto.create.UserAddressInfo;
import com.models.online.system.download.service.domain.dto.create.DownloadModel;
import com.models.online.system.download.service.domain.entity.*;
import com.models.online.system.download.service.domain.mapper.DownloadDataMapper;
import com.models.online.system.download.service.domain.ports.input.service.DownloadApplicationService;
import com.models.online.system.download.service.domain.ports.output.repository.CategoryRepository;
import com.models.online.system.download.service.domain.ports.output.repository.CustomerRepository;
import com.models.online.system.download.service.domain.ports.output.repository.DownloadRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = DownloadTestConfiguration.class)
public class DownloadApplicationServiceTest {

    @Autowired
    private DownloadApplicationService downloadApplicationService;

    @Autowired
    private DownloadDataMapper downloadDataMapper;
    @Autowired
    private DownloadRepository downloadRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private CreateDownloadCommand createDownloadCommand;
    private CreateDownloadCommand createDownloadCommandWrongPrice;
    private CreateDownloadCommand createDownloadCommandWrongProductPrice;
    private final UUID CUSTOMER_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");
    private final UUID CATEGORY_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb45");
    private final UUID MODEL_ID = UUID.fromString("15a497c1-0f4b-4eff-b9f4-c402c8c07afb");
    private final UUID DOWNLOAD_ID = UUID.fromString("11a497c1-0f4b-4eff-b9f4-c402c8c07afb");
    private final BigDecimal PRICE = new BigDecimal("100.00");

    @BeforeAll
    public void init() {
        createDownloadCommand = CreateDownloadCommand.builder()
                .customerId(CUSTOMER_ID)
                .categoryId(CATEGORY_ID)
                .downloadAddress(UserAddressInfo.builder()
                        .country("BG")
                        .city("SOFIA")
                        .email("testa@testa.com")
                        .build())
                .price(PRICE)
                .items(List.of(DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("50.00"))
                                .build(),
                        DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("50.00"))
                                .build()))
                .build();

        createDownloadCommandWrongPrice = CreateDownloadCommand.builder()
                .customerId(CUSTOMER_ID)
                .categoryId(CATEGORY_ID)
                .downloadAddress(UserAddressInfo.builder()
                        .country("BG")
                        .city("SOFIA")
                        .email("testa@testa.com")
                        .build())
                .price(new BigDecimal("250.00"))
                .items(List.of(DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("50.00"))
                                .build(),
                        DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("50.00"))
                                .build()))
                .build();
        createDownloadCommandWrongProductPrice = CreateDownloadCommand.builder()
                .customerId(CUSTOMER_ID)
                .categoryId(CATEGORY_ID)
                .downloadAddress(UserAddressInfo.builder()
                        .country("BG")
                        .city("SOFIA")
                        .email("testa@testa.com")
                        .build())
                .price(new BigDecimal("110.00"))
                .items(List.of(DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("60.00"))
                                .build(),
                        DownloadModel.builder()
                                .modelId(MODEL_ID)
                                .price(new BigDecimal("50.00"))
                                .build()))
                .build();

        Customer customer = new Customer();
        customer.setId(new CustomerId(CUSTOMER_ID));

        Category categoryResponse = new Category.Builder()
                .categoryId(new CategoryId(createDownloadCommand.getCategoryId()))
                .models(List.of(new Model(new ModelId(MODEL_ID), "test111",
                                new Money(new BigDecimal("50.00"))),
                        new Model(new ModelId(MODEL_ID), "test222",
                                new Money(new BigDecimal("50.00")))))
                .active(true)
                .build();

        Download download = downloadDataMapper.createDownloadCommandToDownload(createDownloadCommand);
        download.setId(new DownloadId(DOWNLOAD_ID));

        when(customerRepository.findCustomer(CUSTOMER_ID)).thenReturn(Optional.of(customer));
        when(categoryRepository.findCategoryInformation(downloadDataMapper.createDownloadCommandToCategory(createDownloadCommand)))
                .thenReturn(Optional.of(categoryResponse));
        when(downloadRepository.save(any(Download.class))).thenReturn(download);
    }


}



