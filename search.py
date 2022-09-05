import sys
from elasticsearch import Elasticsearch
es = Elasticsearch()

query = "earth"
if len(sys.argv) == 2:
    query = sys.argv[1]

body = {
	"query": {
		"match": {
			"purpose": query
		}
	}
}

res = es.search(index="person", body=body)
print("Got %d hits:" % res['hits']['total'])
for hit in res['hits']['hits']:
    print(hit["_source"])