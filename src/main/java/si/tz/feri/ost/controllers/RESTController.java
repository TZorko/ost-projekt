package si.tz.feri.ost.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import si.tz.feri.ost.model.Product;
import si.tz.feri.ost.repositories.ProductRepository;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("api")
public class RESTController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/", "test"})
    public Map test() {
        Map m = new HashMap<String, String>();
        m.put("key", "value");
        return m;
    }

    @GetMapping("products")
    public ResponseEntity<List<Product>> getProducts(@RequestParam Map<String,String> params)
    {
        List<Product> list;
        if (params.size() == 0) {
            list = productRepository.findAll();
        } else {
            //productRepository.
            //return ResponseEntity.noContent().build();
            list = Collections.emptyList();
        }

        //return ResponseEntity.noContent().build();
        return ResponseEntity.ok(list);
        /*
        Product p = new Product();
        p.setName("Product 1");
        p.setDesc("The best product in the World!");
        p.setPrice(BigDecimal.valueOf(10.18));

        try {
            File f = new File("src/main/resources/static/images/pict.jpg");
            System.out.println(f.getAbsolutePath());
            BufferedImage img = ImageIO.read(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(img, "jpg", out);
            p.setPict(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
        */
    }

    @GetMapping("products/{id}")
    public Optional<Product> getProductById(@PathVariable(name = "id") Long productId) {
        return productRepository.findById(productId);
    }

    @PostMapping("products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product)
    {
        Product p = productRepository.save(product);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("api/products/{id}").buildAndExpand(p.getId()).toUri();
        return ResponseEntity.created(location).body(p);
    }
}
