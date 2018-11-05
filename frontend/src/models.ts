import { NumberSymbol } from "@angular/common";

export class Product{
    id: number;
    name: string;
    category: Category;
    unitPrice: number;
    unitsInStock: number;
    description: string;
    cartItem: CartItem;

}

export class Category{
    id: number;
    name: string;
    products: Product[];

}

export class CartItem{
    id: number;
    product: Product;
    quantity: number;
    totalItemPrice: number;
    cart: Cart;


}

export class Cart{
    id: number;
    cartItems: CartItem[];
    totalPrice: number;
    user:User;
}

export class User{
    id: number;
    username: string;
    password: string;
    email: string;
    phoneNo: string;
    
    cart: Cart;
    roles: Role [];
    shoppingHistory: ShoppingHistory;
}

export class Role{
    id: number;
    name: string;
    users: User[];
}
export class ShoppingHistory{
    id: number;
    details: string;
    owner:User;
}
export class Address{
    countryCode: string;
    state: string;
    city: string;
    zipCode: string;
    street: string;
    houseNo: string;
}
