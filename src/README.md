# Waste Management API

## Description

This is an API used to get information on waste categories, their disposal guidelines and recycling tips if any.

## Base URL

The base URL for all API requests is:

`https://localhost:8080`

## Endpoints

### `GET /wastecategory`

Returns a list of all the waste categories

### Response

Returns an Array of JSON Objects of waste Category, each with the following properties:

- `id`: The unique identifier of the category.
- `name`: The name or title of the category.
- `description`: A brief description of the category.
- `disposalGuideline`: a guideline on how to dispose of the waste in a responsible way.
- `recycleTip`: a Tip on how the waste can be recycled.

### Example

Request:

```
GET /wastecategory
```

Response:

```json
[
   {
      "id":1,
      "name":"Bio Waste",
      "description":"organic waste ",
      "disposalGuideline":"Take waste to a permitted location .",
      "recyclingTip":"The waste is converted into compost."
   },
   {
      "id":2,
      "name":"Chemical Waste",
      "description":"any excess, unused, or unwanted chemical.",
      "disposalGuideline":"Use appropriate containers Use plastic containers.",
      "recyclingTip":"The waste can be treated by a treatment facility."
   },
   {
      "id":4,
      "name":"E-Waste",
      "description":"Unused/discarded electrical equipment.",
      "disposalGuideline":"Dispose at a certified e-waste recycler.",
      "recyclingTip":"Ensure that data is wiped from devices before handover."
   }
]
```

### `GET /wastecategory/{id}`

Returns a waste category with an id that matches the one specified

### Response

Returns a JSON object with the following properties:

- `id`: The unique identifier of the category.
- `name`: The name or title of the category.
- `description`: A brief description of the category.
- `disposalGuideline`: a guideline on how to dispose of the waste in a responsible way.
- `recycleTip`: a Tip on how the waste can be recycled.

### Example

Request:

```
GET /wastecategory/3
```

Response:

```json
{
	"id":3,
  "name":"Bio Waste",
  "description":"organic waste ",
  "disposalGuideline":"Take waste to a permitted location .",
  "recyclingTip":"The waste is converted into compost."
   }
```

### `POST /wastecategory`

Returns `status code 201` when an object has been created successfully along with the data

### Request

A JSON object with the following properties:

- `name`: The name or title of the category. **(Required!)**
- `description`: A brief description of the category.
- `disposalGuideline`: a guideline on how to dispose of the waste in a responsible way.
- `recycleTip`: a Tip on how the waste can be recycled.

### Response

Returns a JSON object with the following properties and a `status code 201`:

- `id`: The unique identifier of the category.
- `name`: The name or title of the category.
- `description`: A brief description of the category.
- `disposalGuideline`: a guideline on how to dispose of the waste in a responsible way.
- `recycleTip`: a Tip on how the waste can be recycled.

### Example

Request:

```
POST /wastecategory/3

{
  "name":"Bio Waste",
  "description":"organic waste ",
  "disposalGuideline":"Take waste to a permitted location .",
  "recyclingTip":"The waste is converted into compost."
   }
```

Response: `Status code 201`

```json
{
	"id":3,
  "name":"Bio Waste",
  "description":"organic waste ",
  "disposalGuideline":"Take waste to a permitted location .",
  "recyclingTip":"The waste is converted into compost."
   }
```

## Errors

This API uses the following error codes:

- `400 Bad Request`: The request was malformed or missing required parameters.
- `404 Not Found`: The requested resource was not found.
- `500 Internal Server Error`: An unexpected error occurred on the server.