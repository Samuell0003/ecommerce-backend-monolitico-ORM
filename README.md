# Category Controller

The Category Controller is responsible for handling HTTP requests related to managing categories. It provides endpoints for performing CRUD (Create, Read, Update, Delete) operations on categories.

## API Endpoints

### Find all categories

- **URL:** `/api/v1/category`
- **Method:** GET
- **Description:** Retrieves all categories.
- **Responses:**
  - 200 OK: Successfully retrieved categories.
  - 400 Bad Request: The request is malformed or invalid.
  - 401 Unauthorized: Authentication is required to access the resource.
  - 404 Not Found: The requested resource was not found.
  - 500 Internal Server Error: An unexpected error occurred.
- **Response Content Types:**
  - application/json: JSON representation of the categories.
  - application/xml: XML representation of the categories.
  - application/yml: YAML representation of the categories.

### Find a category by ID

- **URL:** `/api/v1/category/{id}`
- **Method:** GET
- **Description:** Retrieves a category by its ID.
- **Parameters:**
  - id (path): ID of the category to retrieve.
- **Responses:**
  - 200 OK: Successfully retrieved the category.
  - 400 Bad Request: The request is malformed or invalid.
  - 401 Unauthorized: Authentication is required to access the resource.
  - 404 Not Found: The requested resource was not found.
  - 500 Internal Server Error: An unexpected error occurred.
- **Response Content Types:**
  - application/json: JSON representation of the category.
  - application/xml: XML representation of the category.
  - application/yml: YAML representation of the category.

### Create a category

- **URL:** `/api/v1/category`
- **Method:** POST
- **Description:** Creates a new category.
- **Request Body:** CategoryVO object representing the category to create.
- **Responses:**
  - 200 OK: Successfully created the category.
  - 400 Bad Request: The request is malformed or invalid.
  - 401 Unauthorized: Authentication is required to access the resource.
  - 404 Not Found: The requested resource was not found.
  - 500 Internal Server Error: An unexpected error occurred.
- **Request Content Types:**
  - application/json: JSON representation of the category.
  - application/xml: XML representation of the category.
  - application/yml: YAML representation of the category.
- **Response Content Types:**
  - application/json: JSON representation of the created category.
  - application/xml: XML representation of the created category.
  - application/yml: YAML representation of the created category.

### Update a category

- **URL:** `/api/v1/category`
- **Method:** PUT
- **Description:** Updates an existing category.
- **Request Body:** CategoryVO object representing the category to update.
- **Responses:**
  - 200 OK: Successfully updated the category.
  - 400 Bad Request: The request is malformed or invalid.
  - 401 Unauthorized: Authentication is required to access the resource.
  - 404 Not Found: The requested resource was not found.
  - 500 Internal Server Error: An unexpected error occurred.
- **Request Content Types:**
  - application/json: JSON representation of the category.
  - application/xml: XML representation of the category.
  - application/yml: YAML representation of the category.
- **Response Content Types:**
  - application/json: JSON representation of the updated category.
  - application/xml: XML representation of the updated category.
  - application/yml: YAML representation of the updated category.

### Delete a category

- **URL:** `/api/v1/category/{id}`
- **Method:** DELETE
- **Description:** Deletes a category by its ID.
- **Parameters:**
  - id (path): ID of the category to delete.
- **Responses:**
  - 204 No Content: The category was successfully deleted.
  - 400 Bad Request: The request is malformed or invalid.
  - 401 Unauthorized: Authentication is required to access the resource.
  - 404 Not Found: The requested resource was not found.
  - 500 Internal Server Error: An unexpected error occurred.

## Request and Response Formats

The API supports the following request and response formats:

- Request Content Types:
  - application/json: JSON format.
  - application/xml: XML format.
  - application/yml: YAML format.

- Response Content Types:
  - application/json: JSON format.
  - application/xml: XML format.
  - application/yml: YAML format.

## Error Handling

In case of errors, the API returns appropriate HTTP status codes along with error messages in the response body. The possible error codes are:

- 400 Bad Request: The request is malformed or invalid.
- 401 Unauthorized: Authentication is required to access the resource.
- 404 Not Found: The requested resource was not found.
- 500 Internal Server Error: An unexpected error occurred.

## Security

Some endpoints may require authentication to access the resources. Unauthorized access to these endpoints will result in a 401 Unauthorized response.

## Dependencies

The Category Controller depends on the CategoryService for performing category-related operations. The CategoryService is autowired into the controller.

Note: This documentation is based on the provided code snippet and may not cover all aspects of the implementation.
