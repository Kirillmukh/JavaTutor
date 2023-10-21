# JavaTutor

This script gets json from localhost then if address not in xslx script appends address there without duplicates

JSON example:
{
  "addresses": [
    {"address": null},
    {"address": "first address"},
    {"address": "second address"},
    {"address": "first address"}
  ]
}

After this request xlsx will have 2 rows and 1 cols like:

A1: first address
A2: second address

Next requests will append rows
