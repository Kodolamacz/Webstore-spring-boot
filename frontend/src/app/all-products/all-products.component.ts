import { Component, OnInit } from '@angular/core';
import { Product, ProductDTO } from 'src/models';
import { ProductService } from 'src/services/product.service';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.css']
})
export class AllProductsComponent implements OnInit {

  products: ProductDTO[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.productService.getAllProducts().subscribe(data => {

      this.products = data;
      this.products.forEach(prod =>{
       prod.paths = prod.imagePaths.split(',');
      })
      this.products.forEach(temp =>{
        console.log('DUPA ' + temp.paths)
      });
    });
  }

}
