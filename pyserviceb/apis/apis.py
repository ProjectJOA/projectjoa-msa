from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
import json
from apis.sql_api import sql_api

def index(request):
	return HttpResponse("Hello, world. You're at the index.")

def pytest(request):
	params = {}
	params["result"] = sql_api.getDepartments()
	print("======= pytest ======")
	return JsonResponse(params, json_dumps_params={'ensure_ascii':False})