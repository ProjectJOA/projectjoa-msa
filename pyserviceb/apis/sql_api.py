from django.db import connection
from django.db.models import Max
from django.db.models import Prefetch

class sql_api:
    def getDepartments():
        cursor = connection.cursor()
        sql_str = " select emp_no, birth_date, first_name, last_name, gender, hire_date from employees limit 20 "
        cursor.execute(sql_str)
        result = cursor.fetchall()
        return result