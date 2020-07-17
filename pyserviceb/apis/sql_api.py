from django.db import connection
from django.db.models import Max
from django.db.models import Prefetch

class sql_api:
    def getDepartments():
        cursor = connection.cursor()
        sql_str = " select dept_no, dept_name from departments "
        cursor.execute(sql_str)
        result = cursor.fetchall()
        return result