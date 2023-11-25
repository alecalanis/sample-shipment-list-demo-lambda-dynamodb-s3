
function generateShipmentData(uuid) {
return {
  "shipmentId": uuid,
  "recipient": {
    "name": "Frodo",
    "address": {
      "postalCode": "LNDNGB",
      "street": "Privet Drive",
      "number": "4",
      "city": "Middle Earth",
      "additionalInfo": ""
    }
  },
  "sender": {
    "name": "Gandalf",
    "address": {
      "postalCode": "OXFGB",
      "street": "Grimmauld Place",
      "number": "12",
      "city": "Mordor",
      "additionalInfo": ""
    }
  },
  "weight": 1.0
}
}

export default generateShipmentData;
