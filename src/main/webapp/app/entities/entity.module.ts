import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'publisher',
        loadChildren: () => import('./publisher/publisher.module').then(m => m.JhipsterSampleHazelcastMonoPublisherModule),
      },
      {
        path: 'author',
        loadChildren: () => import('./author/author.module').then(m => m.JhipsterSampleHazelcastMonoAuthorModule),
      },
      {
        path: 'client',
        loadChildren: () => import('./client/client.module').then(m => m.JhipsterSampleHazelcastMonoClientModule),
      },
      {
        path: 'book',
        loadChildren: () => import('./book/book.module').then(m => m.JhipsterSampleHazelcastMonoBookModule),
      },
      {
        path: 'borrowed-book',
        loadChildren: () => import('./borrowed-book/borrowed-book.module').then(m => m.JhipsterSampleHazelcastMonoBorrowedBookModule),
      },
      {
        path: 'blog',
        loadChildren: () => import('./blog/blog.module').then(m => m.JhipsterSampleHazelcastMonoBlogModule),
      },
      {
        path: 'post',
        loadChildren: () => import('./post/post.module').then(m => m.JhipsterSampleHazelcastMonoPostModule),
      },
      {
        path: 'tag',
        loadChildren: () => import('./tag/tag.module').then(m => m.JhipsterSampleHazelcastMonoTagModule),
      },
      {
        path: 'category',
        loadChildren: () => import('./category/category.module').then(m => m.JhipsterSampleHazelcastMonoCategoryModule),
      },
      {
        path: 'product',
        loadChildren: () => import('./product/product.module').then(m => m.JhipsterSampleHazelcastMonoProductModule),
      },
      {
        path: 'customer',
        loadChildren: () => import('./customer/customer.module').then(m => m.JhipsterSampleHazelcastMonoCustomerModule),
      },
      {
        path: 'address',
        loadChildren: () => import('./address/address.module').then(m => m.JhipsterSampleHazelcastMonoAddressModule),
      },
      {
        path: 'wish-list',
        loadChildren: () => import('./wish-list/wish-list.module').then(m => m.JhipsterSampleHazelcastMonoWishListModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class JhipsterSampleHazelcastMonoEntityModule {}
