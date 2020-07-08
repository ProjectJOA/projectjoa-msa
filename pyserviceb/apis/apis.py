from django.shortcuts import render
from django.http import HttpResponse, JsonResponse
import json

def index(request):
	return HttpResponse("Hello, world. You're at the index.")

def pytest(request):
	params = {}
	params["result"] = [1,2,3,4,5]
	print("======= pytest ======")
	return JsonResponse(params, json_dumps_params={'ensure_ascii':False})