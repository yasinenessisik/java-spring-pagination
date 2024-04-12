## Pagination

Pagination is a technique used to divide large datasets into chunks and present them to the user page by page.

### Parameters

- `page`: Specifies the desired page number. Page numbers start from 0.
- `size`: Specifies the number of items to be displayed per page.
- `limit`: Specifies the maximum number of items to retrieve.
- `sort`: Specifies the sorting criteria.
- `distinct`: Specifies whether to retrieve unique values.
- `offset`: Specifies the starting position for retrieving items.

### Example Usage

You should include pagination parameters in the request to the relevant endpoint. For example:

```
GET /books?page=0&size=10&limit=10&sort=createdAt,asc&distinct=true&offset=20
```

This request will retrieve the first page with up to 10 items per page, limit the results to 10 items, sort them by createdAt in ascending order, filter out duplicate values, and start the results from the 20th item.

### Code Examples

#### Retrieve First Page with Pageable

```java
// Retrieve the first page
Page<Book> bookPage = bookRepository.findAll(PageRequest.of(0, 10, Sort.by("createdAt")));

// Check if there is a next page
if (bookPage.hasNext()) {
    // Retrieve the next page
    Page<Book> nextPage = bookRepository.findAll(bookPage.nextPageable());
    // Perform necessary operations using the next page
}
```

#### Retrieve Data with Slice and Check for Next Page

```java
// Retrieve a slice of data
Slice<Book> bookSlice = bookRepository.findAll(PageRequest.of(0, 10, Sort.by("createdAt")));

// Check if there is a next page
if (bookSlice.hasNext()) {
    // Retrieve the next slice
    Slice<Book> nextSlice = bookRepository.findAll(bookSlice.nextPageable());
}
```

These code examples demonstrate how to retrieve data using pagination with Spring Data JPA.
