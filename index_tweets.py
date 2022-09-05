import sys
from json import dumps
from elasticsearch import Elasticsearch

es = Elasticsearch()

def indexProfile(profile):
    es.index(index="person",
         doc_type="_doc",
         body=dumps(profile))  #body is a JSON, profile = dict 


person = {"name":"Earth", "location":"Washington DC", "purpose":"trees"}
person2 = {"name":"Women", "location":"NoVa", "purpose":"women"}
indexProfile(person)
indexProfile(person2)


