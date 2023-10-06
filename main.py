from typing import Union
from pydantic import BaseModel
from fastapi import FastAPI

app = FastAPI()

db = {}

class item(BaseModel):
    name : str
    desc : str

@app.post("/")
def create(item:item):
    db[item.name] = item.desc
    return{"item":item}

@app.get("/")
def get_all_data(name : str):
    return db

@app.delete("/")
def delete_work(name : str):
    del db[name]
    return db

@app.put("/")
def put_updata(item: item):
    db[item.name] = item.desc
    return db 


