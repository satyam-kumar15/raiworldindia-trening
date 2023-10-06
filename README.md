# fastapi
This code is a simple FastAPI application that performs basic CRUD (Create, Read, Update, Delete) operations on a dictionary (`db`) of items. It utilizes Pydantic for data validation and FastAPI for creating the API endpoints.

Let's go through each part of the code:

1. **Imports**:

   - `from typing import Union`: This imports the `Union` class from the `typing` module, which is used to define type hints.
   - `from pydantic import BaseModel`: This imports the `BaseModel` class from the `pydantic` module, which is used for data validation and serialization.
   - `from fastapi import FastAPI`: This imports the `FastAPI` class from the `fastapi` module, which is used to create the FastAPI application.

2. **Creating the FastAPI App**:

   ```python
   app = FastAPI()
   ```

   This line creates an instance of the FastAPI application.

3. **Database Dictionary**:

   ```python
   db = {}
   ```

   This initializes an empty dictionary `db` to store items. It will be used as a simple in-memory database.

4. **Defining a Pydantic Model**:

   ```python
   class item(BaseModel):
       name : str
       desc : str
   ```

   This defines a Pydantic `BaseModel` called `item` with two fields: `name` and `desc`, both of which are of type `str`.

5. **Creating Endpoints**:

   - **Create (POST) Endpoint**:

     ```python
     @app.post("/")
     def create(item: item):
         db[item.name] = item.desc
         return {"item": item}
     ```

     - This decorator specifies that this function will be called when a POST request is made to the root URL (`"/"`).
     - It takes a single argument `item`, which is of type `item` (as defined by the Pydantic model).
     - It then adds a new item to the `db` dictionary using the `name` as the key and `desc` as the value. It returns the added item.

   - **Read (GET) Endpoint**:

     ```python
     @app.get("/")
     def get_all_data(name: str):
         return db
     ```

     - This decorator specifies that this function will be called when a GET request is made to the root URL (`"/"`).
     - It takes a single argument `name`, which is a string.
     - It simply returns the entire `db` dictionary.

   - **Delete (DELETE) Endpoint**:

     ```python
     @app.delete("/")
     def delete_work(name: str):
         del db[name]
         return db
     ```

     - This decorator specifies that this function will be called when a DELETE request is made to the root URL (`"/"`).
     - It takes a single argument `name`, which is a string.
     - It deletes the item with the specified name from the `db` dictionary and returns the updated `db`.

   - **Update (PUT) Endpoint**:

     ```python
     @app.put("/")
     def put_updata(item: item):
         db[item.name] = item.desc
         return db
     ```

     - This decorator specifies that this function will be called when a PUT request is made to the root URL (`"/"`).
     - It takes a single argument `item`, which is of type `item` (as defined by the Pydantic model).
     - It updates the item in the `db` dictionary with the provided `name` and `desc` values and returns the updated `db`.

Each of these functions corresponds to a different HTTP method (POST, GET, DELETE, PUT) and handles requests accordingly.

Remember, this code defines the routes and functions, but you would need to run the FastAPI application using a web server, like Uvicorn or Hypercorn, to actually serve these endpoints.
