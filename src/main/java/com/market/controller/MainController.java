package com.market.controller;

import com.market.dto.category.CategoryDTO;
import com.market.dto.category.CreateCategoryDTO;
import com.market.dto.category.UpdateCategoryDTO;
import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.InvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;
import com.market.dto.invoiceDocumentItem.CreateInvoiceDocumentItemDTO;
import com.market.dto.organization.CreateOrganizationDTO;
import com.market.dto.organization.OrganizationDTO;
import com.market.dto.organization.UpdateOrganizationDTO;
import com.market.dto.organizationCalculate.CreateOrganizationCalculateDTO;
import com.market.dto.product.CreateProductDTO;
import com.market.dto.product.ProductDTO;
import com.market.dto.productPriceHistory.CreateProductPriceHistoryDTO;
import com.market.dto.productPriceHistory.ProductPriceHistoryDTO;
import com.market.dto.unitType.CreateUnitTypeDTO;
import com.market.dto.unitType.UnitTypeDTO;
import com.market.dto.unitType.UpdateUnitTypeDTO;
import com.market.entity.*;
import com.market.helper.Helper;
import com.market.service.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.market.status.ProductPriceStatus.ACTIVE;
import static com.market.status.ProductPriceStatus.INACTIVE;
import static com.market.status.ProductPriceType.BUY;
import static com.market.status.ProductPriceType.SELL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/market")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainController {

    final CategoryService categoryService;
    final OrganizationService organizationService;
    final OrganizationCalculateService organizationCalculateService;
    final UnitTypeService unitTypeService;
    final ProductService productService;
    final ProductPriceHistoryService productPriceHistoryService;
    final InvoiceDocumentService invoiceDocumentService;
    final InvoiceDocumentItemService invoiceDocumentItemService;
    final Helper helper;

    @GetMapping("/main")
    public ModelAndView mainPage() {
        return new ModelAndView("index");
    }

    @GetMapping("/error")
    public ModelAndView errorPage() {
        return new ModelAndView("page-404");
    }

    @GetMapping("/settings")
    public ModelAndView settingsPage() {
        ModelAndView modelAndView = new ModelAndView("settings");
        modelAndView.addObject("categoryNum", categoryService.getCategoryList().size());
        modelAndView.addObject("organizationNum", organizationService.getUndeletedOrganizationList().size());
        modelAndView.addObject("unitTypeNum", unitTypeService.getUnitTypeList().size());
        modelAndView.addObject("productNum", productService.getProductList().size());
        modelAndView.addObject("invoiceDocNum", invoiceDocumentService.getInvoiceDocumentList().size());
        modelAndView.addObject("incomeNum", invoiceDocumentItemService.getInvoiceDocumentItemList().size());
        return modelAndView;
    }

    @PostMapping("/create_category")
    public ModelAndView createCategory(@RequestParam("name") String name) {
        categoryService.createCategory(new CreateCategoryDTO(name));
        return new ModelAndView("redirect:/market/view_categories");
    }

    @PostMapping("/update_category")
    public ModelAndView updateCategory(@RequestParam("id") Long id, @RequestParam("name") String name) {
        categoryService.updateCategory(id, new UpdateCategoryDTO(name));
        return new ModelAndView("redirect:/market/view_categories");
    }

    @GetMapping("/view_category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("viewCategory");
        modelAndView.addObject("category", categoryService.getCategoryById(id));
        return modelAndView;
    }

    @GetMapping("/delete_category/{id}")
    public ModelAndView deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategoryById(id);
        return new ModelAndView("redirect:/market/view_categories");
    }

    @PostMapping("/check_category")
    public Boolean checkCategory(@RequestParam("name") String name, @RequestParam(value = "id", required = false) Long id) {
        Optional<CategoryDTO> categoryDTO = Optional.ofNullable(categoryService.getCategoryByName(name));
        if (id != null && categoryDTO.isPresent()) {
            return !Objects.equals(categoryDTO.get().getId(), id);
        }
        return categoryDTO.isPresent();
    }

    @GetMapping("/view_categories")
    public ModelAndView viewCategoryList() {
        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("categoryList", categoryService.getCategoryList());
        return modelAndView;
    }

    @PostMapping("/create_organization")
    public ModelAndView createOrganization(@RequestParam("name") String name, @RequestParam("inn") String inn, @RequestParam("address") String address, @RequestParam("phoneNumber") String phoneNumber) {
        OrganizationDTO organizationDTO = organizationService.createOrganization(new CreateOrganizationDTO(name, inn, address, phoneNumber));
        Organization organization = new Organization();
        organization.setId(organizationDTO.getId());
        organizationCalculateService.createOrganizationCalculate(new CreateOrganizationCalculateDTO(organization, 0f, 0f));
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @PostMapping("/update_organization")
    public ModelAndView updateOrganization(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("inn") String inn, @RequestParam("address") String address, @RequestParam("phoneNumber") String phoneNumber) {
        organizationService.updateOrganization(id, new UpdateOrganizationDTO(name, inn, address, phoneNumber));
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @GetMapping("/view_organization/{id}")
    public ModelAndView viewOrganization(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("viewOrganization");
        try {
            modelAndView.addObject("organization", organizationService.getOrganizationById(id));
            modelAndView.addObject("invoiceDocumentList", invoiceDocumentService.getInvoiceDocumentListByOrganizationAndIntervalDate(Organization.builder().id(id).build(), Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now())));
        } catch (Exception e) {
            return new ModelAndView("redirect:/market/error");
        }
        return modelAndView;
    }

    @GetMapping("/delete_organization/{id}")
    public ModelAndView deleteOrganization(@PathVariable("id") Long id) {
        organizationService.deleteOrganizationById(id);
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @PostMapping("/check_organization")
    public Boolean checkOrganization(@RequestParam("name") String name, @RequestParam("inn") String inn, @RequestParam(value = "id", required = false) Long id) {
        Optional<OrganizationDTO> organizationDTO = Optional.ofNullable(organizationService.getOrganizationByNameAndInn(name, inn));
        if (id != null && organizationDTO.isPresent()) {
            return !Objects.equals(organizationDTO.get().getId(), id);
        }
        return organizationDTO.isPresent();
    }

    @GetMapping("/view_organizations")
    public ModelAndView viewOrganizationList() {
        ModelAndView modelAndView = new ModelAndView("organization");
        modelAndView.addObject("organizationList", organizationService.getUndeletedOrganizationList());
        return modelAndView;
    }

    @PostMapping("/view_organization_interval")
    public ModelAndView viewOrganizationListIntervalDate(@RequestParam("id") Long id, @RequestParam("begin") Date begin, @RequestParam("end") Date end) {
        ModelAndView modelAndView = new ModelAndView("viewOrganization");
        modelAndView.addObject("organization", organizationService.getOrganizationById(id));
        modelAndView.addObject("invoiceDocumentList", invoiceDocumentService.getInvoiceDocumentListByOrganizationAndIntervalDate(Organization.builder().id(id).build(), begin, end));
        return modelAndView;
    }

    @GetMapping("/view_organizations_list")
    public ModelAndView viewOrganizationListForWarehouse() {
        ModelAndView modelAndView = new ModelAndView("menuOrganization");
        modelAndView.addObject("organizationList", organizationService.getUndeletedOrganizationList());
        return modelAndView;
    }

    @PostMapping("/create_unit_type")
    public ModelAndView createUnitType(@RequestParam("name") String name) {
        unitTypeService.createUnitType(new CreateUnitTypeDTO(name));
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @PostMapping("/check_unit_type")
    public Boolean checkUnitType(@RequestParam("name") String name, @RequestParam(value = "id", required = false) Long id) {
        Optional<UnitTypeDTO> unitType = Optional.ofNullable(unitTypeService.getUnitTypeByName(name));
        if (id != null && unitType.isPresent()) {
            return !unitType.get().getId().equals(id);
        }
        return unitType.isPresent();
    }

    @PostMapping("/update_unit_type")
    public ModelAndView updateUnitType(@RequestParam("id") Long id, @RequestParam("name") String name) {
        unitTypeService.updateUnitType(id, new UpdateUnitTypeDTO(name));
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @GetMapping("/delete_unit_type/{id}")
    public ModelAndView deleteUnitType(@PathVariable("id") Long id) {
        unitTypeService.deleteUnitTypeById(id);
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @GetMapping("/view_unit_types")
    public ModelAndView viewUnitTypeList() {
        ModelAndView modelAndView = new ModelAndView("unitType");
        modelAndView.addObject("unitTypeList", unitTypeService.getUnitTypeList());
        return modelAndView;
    }

    @PostMapping("/create_product")
    public ModelAndView createProduct(@RequestParam("name") String name, @RequestParam("unitTypeId") Long unitTypeId, @RequestParam("categoryId") Long categoryId, @RequestParam("purchasePrice") Float purchasePrice, @RequestParam("sellPrice") Float sellPrice) {
        ProductDTO productDTO = productService.createProduct(new CreateProductDTO(name, UnitType.builder().id(unitTypeId).build(), Category.builder().id(categoryId).build()));
        productPriceHistoryService.createProductPriceHistory(new CreateProductPriceHistoryDTO(Product.builder().id(productDTO.getId()).build(), purchasePrice, BUY, ACTIVE));
        productPriceHistoryService.createProductPriceHistory(new CreateProductPriceHistoryDTO(Product.builder().id(productDTO.getId()).build(), sellPrice, SELL, ACTIVE));
        return new ModelAndView("redirect:/market/view_products");
    }

    @PostMapping("/update_product")
    public ModelAndView updateProduct(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("unitTypeId") Long unitTypeId, @RequestParam("categoryId") Long categoryId, @RequestParam("purchasePrice") Float purchasePrice, @RequestParam("sellPrice") Float sellPrice) {
        ProductPriceHistoryDTO productPriceHistoryDTO = productPriceHistoryService.getProductPriceHistoryByProductAndProductPriceType(Product.builder().id(id).build(), BUY, ACTIVE);
        if (!productPriceHistoryDTO.getPrice().equals(purchasePrice)) {
            productPriceHistoryService.updateProductPriceHistoryById(productPriceHistoryDTO.getId(), INACTIVE);
            productPriceHistoryService.createProductPriceHistory(new CreateProductPriceHistoryDTO(Product.builder().id(id).build(), purchasePrice, BUY, ACTIVE));
        }

        ProductPriceHistoryDTO productPriceHistoryDTO2 = productPriceHistoryService.getProductPriceHistoryByProductAndProductPriceType(Product.builder().id(id).build(), SELL, ACTIVE);
        if (!productPriceHistoryDTO2.getPrice().equals(sellPrice)) {
            productPriceHistoryService.updateProductPriceHistoryById(productPriceHistoryDTO2.getId(), INACTIVE);
            productPriceHistoryService.createProductPriceHistory(new CreateProductPriceHistoryDTO(Product.builder().id(id).build(), sellPrice, SELL, ACTIVE));
        }
        return new ModelAndView("redirect:/market/view_products");
    }

    @GetMapping("/view_product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("productPriceHistory");
        modelAndView.addObject("product", productService.getProductById(id));
        return modelAndView;
    }

    @GetMapping("/delete_product/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return new ModelAndView("redirect:/market/view_products");
    }

    @PostMapping("/check_product")
    public Boolean checkProduct(@RequestParam("name") String name) {
        ProductDTO productDTO = productService.getProductByName(name);
        return productDTO != null;
    }

    @GetMapping("/view_products")
    public ModelAndView viewProductList() {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("categoryList", categoryService.getCategoryList());
        modelAndView.addObject("unitTypeList", unitTypeService.getUnitTypeList());
        List<ProductDTO> productDTOList = productService.getProductList().stream()
                .peek(x -> {
                    x.setBuyPrice(productPriceHistoryService.getProductPriceHistoryByProductAndProductPriceType(Product.builder().id(x.getId()).build(), BUY, ACTIVE).getPrice());
                    x.setSellPrice(productPriceHistoryService.getProductPriceHistoryByProductAndProductPriceType(Product.builder().id(x.getId()).build(), SELL, ACTIVE).getPrice());
                }).collect(Collectors.toList());
        modelAndView.addObject("productList", productDTOList);
        return modelAndView;
    }

    @PostMapping("/create_invoice_document")
    public ModelAndView createInvoiceDocument(@RequestParam("date") Date date, @RequestParam("docNum") String docNum, @RequestParam("organizationId") Long organizationId) {
        invoiceDocumentService.createInvoiceDocument(new CreateInvoiceDocumentDTO(docNum, Organization.builder().id(organizationId).build(), date));
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @PostMapping("/update_invoice_document")
    public ModelAndView updateInvoiceDocument(@RequestParam("id") Long id, @RequestParam("docNum") String docNum, @RequestParam("date") Date date, @RequestParam("organizationId") Long organizationId) {
        invoiceDocumentService.updateInvoiceDocumentById(id, new UpdateInvoiceDocumentDTO(docNum, Organization.builder().id(organizationId).build(), date));
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @GetMapping("/view_invoice_document/{id}")
    public ModelAndView viewInvoiceDocument(@PathVariable("id") Long id) {
        invoiceDocumentService.getInvoiceDocumentById(id);
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @PostMapping("/check_invoice_document")
    public Boolean checkInvoiceDocument(@RequestParam("docId") Long docId, @RequestParam("organizationId") Long organizationId, @RequestParam("docNumber") String docNumber, @RequestParam("date") String date) {
        Optional<InvoiceDocumentDTO> invoiceDocumentDTO = Optional.ofNullable(invoiceDocumentService.getInvoiceDocumentByOrganizationAndDocumentNumberAndDate(Organization.builder().id(organizationId).build(), docNumber, Date.valueOf(date)));
        if (docId != null && invoiceDocumentDTO.isPresent()) {
            return !invoiceDocumentDTO.get().getId().equals(docId);
        }
        return invoiceDocumentDTO.isPresent();
    }

    @GetMapping("/delete_invoice_document/{id}")
    public ModelAndView deleteInvoiceDocument(@PathVariable("id") Long id) {
        invoiceDocumentService.deleteInvoiceDocumentById(id);
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @GetMapping("/view_invoice_documents")
    public ModelAndView viewInvoiceDocumentList() {
        ModelAndView modelAndView = new ModelAndView("invoiceDocument");
        modelAndView.addObject("invoiceDocumentList", invoiceDocumentService.getInvoiceDocumentList());
        modelAndView.addObject("organizationList", organizationService.getUndeletedOrganizationList());
        return modelAndView;
    }

    @PostMapping("/create_invoice_document_item")
    public ModelAndView createInvoiceDocumentItem(@RequestParam("invoiceDocId") Long invoiceDocId, @RequestParam("productId") Long productId, @RequestParam("amount") Float amount) {
        ProductPriceHistoryDTO productPriceHistory = productPriceHistoryService.getProductPriceHistoryByProductAndProductPriceType(Product.builder().id(productId).build(), BUY, ACTIVE);
        invoiceDocumentItemService.createInvoiceDocumentItem(new CreateInvoiceDocumentItemDTO(InvoiceDocument.builder().id(invoiceDocId).build(), Product.builder().id(productId).build(), amount, productPriceHistory.getPrice(), amount));
        return new ModelAndView("redirect:/market/view_invoice_document_items");
    }

    @GetMapping("/view_invoice_document_item/{id}")
    public ModelAndView viewInvoiceDocumentItem(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("viewInvoiceDocumentItem");
        modelAndView.addObject("invoiceDocumentItemList", invoiceDocumentService.getInvoiceDocumentById(id).getInvoiceDocumentItemList());
        return modelAndView;
    }

    @GetMapping("/view_invoice_document_items")
    public ModelAndView viewInvoiceDocumentItemList() {
        ModelAndView modelAndView = new ModelAndView("invoiceDocumentItem");
        modelAndView.addObject("invoiceDocumentItemList", invoiceDocumentItemService.getInvoiceDocumentItemList());
        modelAndView.addObject("invoiceDocumentList", invoiceDocumentService.getInvoiceDocumentList());
        modelAndView.addObject("productList", productService.getProductList());
        return modelAndView;
    }
}
