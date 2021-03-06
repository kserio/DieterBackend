import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";
import {ProductSearchService} from "../../../_service/product-search.service";
import {Product} from "../../../_model/product";

@Component({
    selector: 'product-search',
    templateUrl: './product-search.component.html',
    styleUrls: ['./product-search.component.css'],
    providers: [ProductSearchService]
})

export class ProductSearchComponent implements OnInit {

    products: Observable<Product[]>;
    private searchTerms = new Subject<string>();

    constructor(private productSearchService: ProductSearchService,
                private router: Router) {
    }

    search(term: string): void {
        this.searchTerms.next(term);
    }

    ngOnInit(): void {
        this.products = this.searchTerms
            .debounceTime(300)
            .distinctUntilChanged()
            .switchMap(term => term ? this.productSearchService.search(term) : Observable.of<Product[]>([]))
            .catch(error => {
                console.log(error);
                return Observable.of<Product[]>([]);
            });
    }

    goToDetail(product: Product): void {
        let link = ['/product', product.productId];
        this.router.navigate(link);
    }
}