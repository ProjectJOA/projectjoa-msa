import py_eureka_client.eureka_client as eureka_client
import os

def startup():
	env = os.environ.copy()
	EN_EUREKA_SERVER_URL = env['EN_EUREKA_SERVER_URL']
	EN_EUREKA_PORT = env['EN_EUREKA_PORT']

	try:
		your_rest_server_port = 9094
		# The flowing code will register your server to eureka server and also start to send heartbeat every 30 seconds
		eureka_client.init(eureka_server="http://"+EN_EUREKA_SERVER_URL+":"+EN_EUREKA_PORT+"/eureka",
		                   app_name="projectjoa-pyserviceb",
		                   instance_port=your_rest_server_port,
	                   	   ha_strategy=eureka_client.HA_STRATEGY_OTHER)
	except Exception as e:
		print("예외가 발생했습니다.",e)

startup()