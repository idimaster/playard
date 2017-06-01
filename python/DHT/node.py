from flask import Flask, jsonify, abort, request
import datetime as dt

app = Flask(__name__)

items = {'ee': {}}



@app.route('/hash/api/v1.0/get/<string:h>', methods=['GET'])
def get_item(h):
    if h not in items:
        abort(404)
    return jsonify({'item': items[h]})


@app.route('/hash/api/v1.0/put/<string:h>', methods=['PUT'])
def put_item(h):
    if not request.json:
        abort(400)
    items[h] = request.json
    return jsonify({'item': request.json})

if __name__ == '__main__':
    app.run(debug=True)
