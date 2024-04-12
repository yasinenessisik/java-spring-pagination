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

### JSON Examples

JSON examples containing pagination, limit, sort, distinct, and offset parameters:

```json
{
  "page": 0,
  "size": 10,
  "limit": 10,
  "sort": "createdAt,asc",
  "distinct": true,
  "offset": 20
}
```

This JSON example retrieves the first page with up to 10 items per page, limits the results to 10 items, sorts them by createdAt in ascending order, filters out duplicate values, and starts the results from the 20th item.
