//package com.scaler.cart;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RequestCallback;
//import org.springframework.web.client.ResponseExtractor;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.ArrayList;
//
//// @SpringBootApplication
//public class FakeStoreCartSolution {
//    public static void main(String[] args) {
//        SpringApplication.run(FakeStoreCartSolution.class, args);
//    }
//
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//}
//
//class Cart {
//    private Long id;
//    private Long userId;
//    private Date date;
//    private List<CartProduct> products;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public List<CartProduct> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<CartProduct> products) {
//        this.products = products;
//    }
//}
//
//class CartProduct {
//    private Long productId;
//    private Integer quantity;
//
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//}
//
//class FakeStoreCartDto {
//    private Long id;
//    private Long userId;
//    private Date date;
//    private List<FakeStoreProductDto> products;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public List<FakeStoreProductDto> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<FakeStoreProductDto> products) {
//        this.products = products;
//    }
//}
//
//class FakeStoreProductDto {
//    private Long productId;
//    private Integer quantity;
//
//    public Long getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Long productId) {
//        this.productId = productId;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//}
//
//interface ICartService {
//    Cart getCart(Long cartId);
//
//    List<Cart> getUserCarts(Long userId);
//
//    Cart createCart(Cart cart);
//
//    Cart updateCart(Long cartId, Cart cart);
//
//    Cart deleteCart(Long cartId);
//}
//
//@Component
//class FakeStoreClient {
//    private final RestTemplate restTemplate;
//    private final String BASE_URL = "https://fakestoreapi.com/carts";
//
//    @Autowired
//    public FakeStoreClient(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    // TODO: Implement generic requestForEntity method
//    public <T> ResponseEntity<T> requestForEntity(String url, HttpMethod method, @Nullable Object request, Class<T> responseType) {
//        // TODO: Create HttpEntity and call restTemplate.exchange()
//        return this.restTemplate.exchange(url, method, null, responseType);
//    }
//
//    // TODO: Implement generic requestForList method
//    public <T> ResponseEntity<List<T>> requestForList(String url, HttpMethod method, @Nullable Object request, ParameterizedTypeReference<List<T>> responseType) {
//        // TODO: Create HttpEntity and call restTemplate.exchange()
//        return this.restTemplate.exchange(url, method, null, responseType);
//    }
//
//    public FakeStoreCartDto getCart(Long id) {
//        // TODO: Call FakeStore API using requestForEntity
//        ResponseEntity<FakeStoreCartDto> cart = this.requestForEntity(this.BASE_URL + "/" + id, HttpMethod.GET, null, FakeStoreCartDto.class);
//        if (!cart.hasBody()) {
//            throw new NullPointerException("Cart is null");
//        }
//        return cart.getBody();
//    }
//
//    public List<FakeStoreCartDto> getUserCarts(Long userId) {
//        // TODO: Call FakeStore API using requestForList
//        ResponseEntity<List<FakeStoreCartDto>> fakeStoreCartDtoResponse =
//                this.requestForList(this.BASE_URL + "/user/" + userId, HttpMethod.GET, null,
//                        new ParameterizedTypeReference<List<FakeStoreCartDto>>() {
//                        });
//        int statusCode = fakeStoreCartDtoResponse.getStatusCode().value();
//        if (!fakeStoreCartDtoResponse.hasBody()) {
//            throw new NullPointerException("");
//        }
//        if (List.of(400, 404, 500).contains(statusCode)) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        }
//        return fakeStoreCartDtoResponse.getBody();
//    }
//
//    public FakeStoreCartDto createCart(FakeStoreCartDto cartDto) {
//        // TODO: Call FakeStore API using requestForEntity
//        ResponseEntity<FakeStoreCartDto> response = this.requestForEntity(this.BASE_URL, HttpMethod.POST, cartDto, FakeStoreCartDto.class);
//        if (!response.hasBody()) {
//            throw new RuntimeException("Unable to create cart");
//        }
//        return response.getBody();
//    }
//
//    public FakeStoreCartDto updateCart(Long id, FakeStoreCartDto cartDto) {
//        // TODO: Call FakeStore API using requestForEntity
//        if (id == null) {
//            throw new NullPointerException("Id cannot be null");
//        }
//        cartDto.setId(id);
//        ResponseEntity<FakeStoreCartDto> responseEntity = this.requestForEntity(
//                this.BASE_URL + "/" + id,
//                HttpMethod.PUT,
//                cartDto,
//                FakeStoreCartDto.class
//        );
//        if (!responseEntity.hasBody()) {
//            throw new RuntimeException("Unable to update cart");
//        }
//        return responseEntity.getBody();
//    }
//
//    public FakeStoreCartDto deleteCart(Long id) {
//        // TODO: Call FakeStore API using requestForEntity
//        ResponseEntity<FakeStoreCartDto> responseEntity = this.requestForEntity(this.BASE_URL + "/" + id, HttpMethod.DELETE, null, FakeStoreCartDto.class);
//        return responseEntity.getBody();
//    }
//}
//
//@Service
//class FakeStoreCartService implements ICartService {
//
//    private final FakeStoreClient fakeStoreClient;
//
//    @Autowired
//    public FakeStoreCartService(FakeStoreClient fakeStoreClient) {
//        this.fakeStoreClient = fakeStoreClient;
//    }
//
//    // TODO: Implement mapToDto to convert Cart to FakeStoreCartDto
//    private FakeStoreCartDto mapToDto(Cart cart) {
//        // TODO: Map Cart fields to FakeStoreCartDto
//        FakeStoreCartDto fakeStoreCartDto = new FakeStoreCartDto();
//        List<CartProduct> cartProductList = cart.getProducts();
//        List<FakeStoreProductDto> productDtoList = new ArrayList<>();
//        fakeStoreCartDto.setDate(cart.getDate());
//        fakeStoreCartDto.setId(cart.getId());
//        fakeStoreCartDto.setUserId(cart.getUserId());
//        for (CartProduct cartProduct : cartProductList) {
//            FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//            fakeStoreProductDto.setProductId(cartProduct.getProductId());
//            fakeStoreProductDto.setQuantity(cartProduct.getQuantity());
//            productDtoList.add(fakeStoreProductDto);
//        }
//        fakeStoreCartDto.setProducts(productDtoList);
//        return fakeStoreCartDto;
//    }
//
//    // TODO: Implement mapToCart to convert FakeStoreCartDto to Cart
//    private Cart mapToCart(FakeStoreCartDto dto) {
//        // TODO: Map FakeStoreCartDto fields to Cart
//        Cart cart = new Cart();
//        cart.setId(dto.getId());
//        cart.setUserId(dto.getUserId());
//        cart.setDate(dto.getDate());
//        List<FakeStoreProductDto> productDtoList = dto.getProducts();
//        if (productDtoList == null) {
//            cart.setProducts(null);
//        } else {
//            List<CartProduct> cartProductList = new ArrayList<>();
//            for (FakeStoreProductDto product : productDtoList) {
//                CartProduct cartProduct = new CartProduct();
//                cartProduct.setProductId(product.getProductId());
//                cartProduct.setQuantity(product.getQuantity());
//                cartProductList.add(cartProduct);
//            }
//            cart.setProducts(cartProductList);
//        }
//        return cart;
//    }
//
//    @Override
//    public Cart getCart(Long cartId) {
//        // TODO: Call fakeStoreClient.getCart() and map response using mapToCart()
//        FakeStoreCartDto cartDto = this.fakeStoreClient.getCart(cartId);
//        return this.mapToCart(cartDto);
//    }
//
//    @Override
//    public List<Cart> getUserCarts(Long userId) {
//        // TODO: Call fakeStoreClient.getUserCarts() and map responses using mapToCart()
//        List<FakeStoreCartDto> fakeStoreCartDtoList = this.fakeStoreClient.getUserCarts(userId);
//        List<Cart> cartList = new ArrayList<>();
//        for (FakeStoreCartDto fakeStoreCartDto : fakeStoreCartDtoList) {
//            Cart cart = this.mapToCart(fakeStoreCartDto);
//            cartList.add(cart);
//        }
//        return cartList;
//    }
//
//    @Override
//    public Cart createCart(Cart cart) {
//        // TODO: Map cart to DTO using mapToDto(), call fakeStoreClient.createCart(), and map response
//        FakeStoreCartDto cartDto = this.mapToDto(cart);
//        FakeStoreCartDto response = this.fakeStoreClient.createCart(cartDto);
//        return this.mapToCart(response);
//    }
//
//    @Override
//    public Cart updateCart(Long cartId, Cart cart) {
//        // TODO: Map cart to DTO using mapToDto(), call fakeStoreClient.updateCart(), and map response
//        FakeStoreCartDto fakeStoreCartDto = this.mapToDto(cart);
//        FakeStoreCartDto cartDto = this.fakeStoreClient.updateCart(cartId, fakeStoreCartDto);
//        return this.mapToCart(cartDto);
//    }
//
//    @Override
//    public Cart deleteCart(Long cartId) {
//        // TODO: Call fakeStoreClient.deleteCart() and map response using mapToCart()
//        FakeStoreCartDto cartDto = this.fakeStoreClient.deleteCart(cartId);
//        return null;
//    }
//}
//
//@RestController
//@RequestMapping("/cart")
//class CartController {
//
//    private final ICartService cartService;
//
//    @Autowired
//    public CartController(ICartService cartService) {
//        this.cartService = cartService;
//    }
//
//    // TODO: Implement GET /cart/{cartId} endpoint
//    @GetMapping("/{cartId}")
//    public Cart getCart(@PathVariable Long cartId) {
//        return this.cartService.getCart(cartId);
//    }
//
//    // TODO: Implement GET /cart/user/{userId} endpoint
//    @GetMapping("/user/{userId}")
//    public List<Cart> getUserCarts(@PathVariable Long userId) {
//        // TODO: Call cartService.getUserCarts()
//        return this.cartService.getUserCarts(userId);
//    }
//
//    // TODO: Implement POST /cart endpoint
//    @PostMapping
//    public Cart createCart(@RequestBody Cart cart) {
//        // TODO: Call cartService.createCart()
//        return this.cartService.createCart(cart);
//    }
//
//    // TODO: Implement PUT /cart/{cartId} endpoint
//    @PutMapping("/{cartId}")
//    public Cart updateCart(@PathVariable Long cartId, @RequestBody Cart cart) {
//        // TODO: Call cartService.updateCart()
//        return this.cartService.updateCart(cartId, cart);
//    }
//
//    // TODO: Implement DELETE /cart/{cartId} endpoint
//    @DeleteMapping("/{cartId}")
//    public Cart deleteCart(@PathVariable Long cartId) {
//        // TODO: Call cartService.deleteCart()
//        return this.cartService.deleteCart(cartId);
//    }
//}