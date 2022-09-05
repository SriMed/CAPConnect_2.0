import requests
import json
import sys 

if(len(sys.argv) > 1):
	my_level = sys.argv[1]
	my_address = sys.argv[2]
else:
	my_level = 'NATIONAL_LOWER'
	my_address = '6560 Braddock Rd'


x_api_key = 'ie5EtNqb2pafUpw0FsMC84hHqrW9L4uf2Ql9YTJF' 

endpoint = 'https://fmrrixuk32.execute-api.us-east-1.amazonaws.com/hacktj/legislators'
parameters = {
  'level': my_level,
  'address': my_address
}
headers = {
  'X-API-Key': x_api_key
}

response = requests.get(endpoint, params=parameters, headers=headers)
representatives = json.loads(response.text)['officials']

if(len(representatives) == 0): print("No representatives found.")

for representative in representatives:
    first_name = representative['first_name']
    last_name = representative['last_name']
    chamber_details = representative['office_details']['chamber_details']['name']
    print('Your Representative in national Congress is ' + first_name + ' ' + last_name)
    print('He/She is in the ' + chamber_details)