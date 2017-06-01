import requests

task = {"summary": "Take out trash", "description": "" }

resp = requests.put('http://localhost:5000/hash/api/v1.0/put/test', json=task)

if resp.status_code != 200:
    raise IndexError('PUT/item/ {}'.format(resp.status_code))
print(resp.json())

resp1 = requests.get('http://localhost:5000/hash/api/v1.0/get/test')

if resp1.status_code != 200:
    raise IndexError('GET /item/ {}'.format(resp.status_code))
print(resp1.json())
