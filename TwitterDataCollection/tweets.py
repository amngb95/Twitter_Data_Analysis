import tweepy
import csv
import pandas as pd
####input your credentials here
consumer_key = '69SNKxw0qbGY6PPZBcRVLZVpP'
consumer_secret = 'sIUppqVb3mDXDdbnXGst50fL2DvmtcyjakxbJhA7D5vQpt3PNr'
access_token = '1039586617445572608-3R3OHxxrH5JY8e9IITG3w3pwkZpGFc'
access_token_secret = 'KrqdNUh5tddGq1SW1SUIeQMBelQcyLzQVOaOzAPfNZG84'

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth,wait_on_rate_limit=True)
#####United Airlines
# Open/Create a file to append data
csvFile = open('Army.csv', 'a')
#Use csv Writer
csvWriter = csv.writer(csvFile)

for tweet in tweepy.Cursor(api.search,q="#IndianArmy",count=1000,
                           lang="en",
                           since="2012-04-03").items():
	csvWriter.writerow([tweet.created_at,tweet.text.encode('utf-8')])
    

