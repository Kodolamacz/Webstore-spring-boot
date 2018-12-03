import { Component, OnInit } from '@angular/core';
import { Category } from '../../models';
import { CategoryService } from '../../services/category.service';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  category: Category = new Category();
  constructor(private catService: CategoryService) { }

  ngOnInit() {
  }

  addCategory(){

    this.catService.addCategory(this.category).subscribe(data => {
      alert("Dodano");
    })
  }

}
