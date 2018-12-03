import { Component, OnInit } from '@angular/core';
import {Product, Category} from "../../models";
import {ProductService} from "../../services/product.service";
import {CategoryService} from "../../services/category.service";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  selectedFiles: File[] = [];
  uploadData = new FormData();
  product: Product = new Product();
  categories: Category[] = [];
  productCategory: Category;

  constructor(private productService: ProductService, private categoryService: CategoryService) { }

  ngOnInit() {
     this.categoryService.getAll().subscribe(data => {
      this.categories = data;
      }
    )
  }

  addProduct(){
    console.log(this.productCategory);
    if(this.productCategory === undefined){
      this.productCategory = this.categories[0];
    }
    this.productService.addProduct(this.product, this.selectedFiles, this.productCategory).subscribe(data => {
      console.log(data);
    })
  }


  uploadFile(event){
    for(var i = 0 ; i < event.target.files.length; i ++){
      this.selectedFiles.push(event.target.files[i]);
    }

    // console.log(this.selectedFile);
//     this.selectedFile = event.target.files[0];
//     this.uploadData.append('myFile', this.selectedFile, this.selectedFile.name);
//     let files = event.target.files;
//     console.log(files + " kupa ");

//     if (files.length > 0) {
//       for( let file of files){
//         console.log(file[0] + " kupa " + typeof file[0]);

//         // this.product.images = this.uploadData;
//        }
// }
  }
}
