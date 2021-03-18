package com.apiviews.apiviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String GetProducts(Model model){
        model.addAttribute("ListProducts",productService.GetProducts());
        return"index";
    }
    @GetMapping("/ShowNewProductForm")
    public String ShowNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("Product",product);
        return"new_Product";
    }

    @PostMapping("/saveproduct")
    public String SaveProduct(@ModelAttribute("Product") Product product){
        productService.SaveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(Model model,@PathVariable("id") int id){
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        return "update";
    }

    @PostMapping("/showFormForUpdate/{id}")
    public String UpdateProduct(@ModelAttribute("product") Product product){
        productService.UpdateProduct(product);
        return "redirect:/products";
    }
    @GetMapping("showFormForDelete/{id}")
    public String DeleteProduct(@PathVariable("id") int id){
        productService.DeleteProduct(id);
        return "redirect:/products";
    }
    
}
