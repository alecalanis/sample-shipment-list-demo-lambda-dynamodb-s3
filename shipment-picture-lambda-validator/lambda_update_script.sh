#!/bin/bash -x

# you need to have maven installed for this. package jar
mvn clean package shade:shade

#you need awslocal cli installed for this. deploy on awslocal
x=$(which awslocal)
if [ $? -eq 0 ]; then
    awslocal lambda update-function-code --function-name shipment-picture-lambda-validator \
            --zip-file fileb://target/shipment-picture-lambda-validator.jar \
            --region us-east-1
else
    echo "awslocal is not installed"
fi

# you need aws cli installed for this.deploy on aws
x=$(which aws)
if [ $? -eq 0 ]; then
    aws lambda update-function-code --function-name shipment-picture-lambda-validator \
         --zip-file fileb://target/shipment-picture-lambda-validator.jar \
         --region us-east-1
else
    echo "aws is not installed"
fi
