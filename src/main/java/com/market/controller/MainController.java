package com.market.controller;

import com.market.dto.category.CreateCategoryDTO;
import com.market.dto.category.UpdateCategoryDTO;
import com.market.dto.invoiceDocument.CreateInvoiceDocumentDTO;
import com.market.dto.invoiceDocument.UpdateInvoiceDocumentDTO;
import com.market.dto.invoiceDocumentItem.CreateInvoiceDocumentItemDTO;
import com.market.dto.organization.CreateOrganizationDTO;
import com.market.dto.organization.UpdateOrganizationDTO;
import com.market.dto.product.CreateProductDTO;
import com.market.dto.product.ProductDTO;
import com.market.dto.product.UpdateProductDTO;
import com.market.dto.productPurchasePrice.CreateProductPurchasePriceDTO;
import com.market.dto.productPurchasePrice.ProductPurchasePriceDTO;
import com.market.dto.productSellPrice.CreateProductSellPriceDTO;
import com.market.dto.productSellPrice.ProductSellPriceDTO;
import com.market.dto.unitType.CreateUnitTypeDTO;
import com.market.dto.unitType.UpdateUnitTypeDTO;
import com.market.entity.*;
import com.market.helper.Helper;
import com.market.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MainController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    OrganizationService organizationService;

    @Autowired
    UnitTypeService unitTypeService;

    @Autowired
    ProductPurchasePriceService productPurchasePriceService;

    @Autowired
    ProductSellPriceService productSellPriceService;

    @Autowired
    ProductService productService;

    @Autowired
    InvoiceDocumentService invoiceDocumentService;

    @Autowired
    InvoiceDocumentItemService invoiceDocumentItemService;

    @Autowired
    Helper helper;

    @GetMapping("/main")
    public ModelAndView mainPage(){
        return new ModelAndView("index");
    }

    @GetMapping("/settings")
    public ModelAndView settingsPage(){
        ModelAndView modelAndView = new ModelAndView("settings");
        modelAndView.addObject("categoryNum",categoryService.getCategoryList().size());
        return modelAndView;
    }

    @PostMapping("/create_category")
    public ModelAndView createCategory(@RequestParam("name") String name){
        categoryService.createCategory(new CreateCategoryDTO(name));
        return new ModelAndView("redirect:/market/view_categories");
    }

    @PostMapping("/update_category")
    public ModelAndView updateCategory(@RequestParam("id") Long id,@RequestParam("name") String name){
        categoryService.updateCategory(id,new UpdateCategoryDTO(name));
        return new ModelAndView("redirect:/market/view_categories");
    }

    @GetMapping("/view_category/{id}")
    public ModelAndView viewCategory(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("productListForCategory");
        modelAndView.addObject("category",categoryService.getCategoryById(id));
        return modelAndView;
    }

    @GetMapping("/delete_category/{id}")
    public ModelAndView deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return new ModelAndView("redirect:/market/view_categories");
    }

    @GetMapping("/view_categories")
    public ModelAndView viewCategoryList(){
        ModelAndView modelAndView = new ModelAndView("category");
        modelAndView.addObject("categoryList",categoryService.getCategoryList());
        return modelAndView;
    }

    @PostMapping("/create_organization")
    public ModelAndView createOrganization(@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber){
        organizationService.createOrganization(new CreateOrganizationDTO(name,address,phoneNumber));
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @PostMapping("/update_organization")
    public ModelAndView updateOrganization(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber){
        organizationService.updateOrganization(id,new UpdateOrganizationDTO(name,address,phoneNumber));
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @GetMapping("/view_organization/{id}")
    public ModelAndView viewOrganization(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("invoiceListForOrganization");
        modelAndView.addObject("organization",organizationService.getOrganizationById(id));
        return modelAndView;
    }

    @GetMapping("/delete_organization/{id}")
    public ModelAndView deleteOrganization(@PathVariable("id") Long id){
        organizationService.deleteOrganizationById(id);
        return new ModelAndView("redirect:/market/view_organizations");
    }

    @GetMapping("/view_organizations")
    public ModelAndView viewOrganizationList(){
        ModelAndView modelAndView = new ModelAndView("organization");
        modelAndView.addObject("organizationList",organizationService.getOrganizationList());
        modelAndView.addObject("status",0);
        return modelAndView;
    }

    @GetMapping("/view_organizations_list")
    public ModelAndView viewOrganizationListForWarehouse(){
        ModelAndView modelAndView = new ModelAndView("organization");
        modelAndView.addObject("organizationList",organizationService.getOrganizationList());
        modelAndView.addObject("status",1);
        return modelAndView;
    }

    @PostMapping("/create_unit_type")
    public ModelAndView createUnitType(@RequestParam("name") String name){
        unitTypeService.createUnitType(new CreateUnitTypeDTO(name));
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @PostMapping("/update_unit_type")
    public ModelAndView updateUnitType(@RequestParam("id") Long id,@RequestParam("name") String name){
        unitTypeService.updateUnitType(id,new UpdateUnitTypeDTO(name));
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @GetMapping("/view_unit_type/{id}")
    public ModelAndView viewUnitType(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("unitType");
        modelAndView.addObject("unitType",unitTypeService.getUnitTypeById(id));
        return modelAndView;
    }

    @GetMapping("/delete_unit_type/{id}")
    public ModelAndView deleteUnitType(@PathVariable("id") Long id){
        unitTypeService.deleteUnitTypeById(id);
        return new ModelAndView("redirect:/market/view_unit_types");
    }

    @GetMapping("/view_unit_types")
    public ModelAndView viewUnitTypeList(){
        ModelAndView modelAndView = new ModelAndView("unitType");
        modelAndView.addObject("unitTypeList",unitTypeService.getUnitTypeList());
        return modelAndView;
    }

    @PostMapping("/create_product")
    public ModelAndView createProduct(@RequestParam("name") String name,@RequestParam("unitTypeId") Long unitTypeId,@RequestParam("categoryId") Long categoryId,@RequestParam("purchasePrice") Float purchasePrice,@RequestParam("sellPrice") Float sellPrice){
        ProductDTO productDTO = productService.createProduct(new CreateProductDTO(name, UnitType.builder().id(unitTypeId).build(), Category.builder().id(categoryId).build(),0f));
        productPurchasePriceService.createProductPurchasePrice(new CreateProductPurchasePriceDTO(Product.builder().id(productDTO.getId()).build(), purchasePrice,true));
        productSellPriceService.createProductSellPrice(new CreateProductSellPriceDTO(Product.builder().id(productDTO.getId()).build(), sellPrice,true));
        return new ModelAndView("redirect:/market/view_products");
    }

    @PostMapping("/update_product")
    public ModelAndView updateProduct(@RequestParam("id") Long id,@RequestParam("name") String name,@RequestParam("unitTypeId") Long unitTypeId,@RequestParam("categoryId") Long categoryId,@RequestParam("purchasePrice") Float purchasePrice,@RequestParam("sellPrice") Float sellPrice){
        ProductPurchasePriceDTO purchasePriceDTO = productPurchasePriceService.getProductPurchasePriceByProduct(Product.builder().id(id).build());
        if (!purchasePriceDTO.getPrice().equals(purchasePrice)) {
            productPurchasePriceService.updateProductPurchasePriceStatusByProduct(Product.builder().id(id).build());
            productPurchasePriceService.createProductPurchasePrice(new CreateProductPurchasePriceDTO(Product.builder().id(id).build(), purchasePrice,true));
        }

        ProductSellPriceDTO productSellPriceDTO = productSellPriceService.getProductSellPriceByProduct(Product.builder().id(id).build());
        if (!productSellPriceDTO.getPrice().equals(sellPrice)){
            productSellPriceService.updateProductSellPriceStatusByProduct(Product.builder().id(id).build());
            productSellPriceService.createProductSellPrice(new CreateProductSellPriceDTO(Product.builder().id(id).build(),sellPrice,true));
        }
        productService.updateProductById(id,new UpdateProductDTO(name, UnitType.builder().id(unitTypeId).build(), Category.builder().id(categoryId).build()));
        return new ModelAndView("redirect:/market/view_products");
    }

    @GetMapping("/view_product/{id}")
    public ModelAndView viewProduct(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("productPriceHistory");
        modelAndView.addObject("product",productService.getProductById(id));
        return modelAndView;
    }

    @GetMapping("/delete_product/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id){
        productService.deleteProductById(id);
        return new ModelAndView("redirect:/market/view_products");
    }

    @GetMapping("/view_products")
    public ModelAndView viewProductList(){
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addObject("categoryList",categoryService.getCategoryList());
        modelAndView.addObject("unitTypeList",unitTypeService.getUnitTypeList());
        modelAndView.addObject("productList",productService.getProductList());
        return modelAndView;
    }

    @PostMapping("/create_invoice_document")
    public ModelAndView createInvoiceDocument(@RequestParam("date") String date, @RequestParam("organizationId") Long organizationId){
        String docNumber = "AC_DOC_"+date.replace("T","_");
        invoiceDocumentService.createInvoiceDocument(new CreateInvoiceDocumentDTO(docNumber, Organization.builder().id(organizationId).build(),helper.convertDatetimeToTimestamp(date.replace("T"," "))));
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @PostMapping("/update_invoice_document")
    public ModelAndView updateInvoiceDocument(@RequestParam("id") Long id,@RequestParam("date") String date, @RequestParam("organizationId") Long organizationId){
        String docNumber = "AC_DOC_"+date.replace("T","_");
        System.out.println(date);
        invoiceDocumentService.updateInvoiceDocumentById(id,new UpdateInvoiceDocumentDTO(docNumber, Organization.builder().id(organizationId).build(),helper.convertDatetimeToTimestamp(date.replace("T"," "))));
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @GetMapping("/view_invoice_document/{id}")
    public ModelAndView viewInvoiceDocument(@PathVariable("id") Long id){
        invoiceDocumentService.getInvoiceDocumentById(id);
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @GetMapping("/delete_invoice_document/{id}")
    public ModelAndView deleteInvoiceDocument(@PathVariable("id") Long id){
        invoiceDocumentService.deleteInvoiceDocumentById(id);
        return new ModelAndView("redirect:/market/view_invoice_documents");
    }

    @GetMapping("/view_invoice_documents")
    public ModelAndView viewInvoiceDocumentList(){
        ModelAndView modelAndView = new ModelAndView("invoiceDocument");
        modelAndView.addObject("invoiceDocumentList",invoiceDocumentService.getInvoiceDocumentList());
        modelAndView.addObject("organizationList",organizationService.getOrganizationList());
        return modelAndView;
    }

    @PostMapping("/create_invoice_document_item")
    public ModelAndView createInvoiceDocumentItem(@RequestParam("invoiceDocId") Long invoiceDocId, @RequestParam("productId") Long productId,@RequestParam("amount") Float amount){
        List<ProductPurchasePriceDTO> purchasePriceDTOS = productPurchasePriceService.getProductPurchaseListPriceByProductAndStatus(Product.builder().id(productId).build());
        Float purchasePrice = purchasePriceDTOS.get(purchasePriceDTOS.size()-1).getPrice();
        invoiceDocumentItemService.createInvoiceDocumentItem(new CreateInvoiceDocumentItemDTO(InvoiceDocument.builder().id(invoiceDocId).build(), Product.builder().id(productId).build(),amount,purchasePrice));
        return new ModelAndView("redirect:/market/view_invoice_document_items");
    }

    @GetMapping("/view_invoice_document_item/{id}")
    public ModelAndView viewInvoiceDocumentItem(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("invoiceDocumentItemForInvoiceDoc");
        modelAndView.addObject("invoiceDocumentItemList",invoiceDocumentService.getInvoiceDocumentById(id).getInvoiceDocumentItemList());
        return modelAndView;
    }

    @GetMapping("/view_invoice_document_items")
    public ModelAndView viewInvoiceDocumentItemList(){
        ModelAndView modelAndView = new ModelAndView("invoiceDocumentItem");
        modelAndView.addObject("invoiceDocumentItemList",invoiceDocumentItemService.getInvoiceDocumentItemList());
        modelAndView.addObject("invoiceDocumentList",invoiceDocumentService.getInvoiceDocumentList());
        modelAndView.addObject("productList",productService.getProductList());
        return modelAndView;
    }
}
