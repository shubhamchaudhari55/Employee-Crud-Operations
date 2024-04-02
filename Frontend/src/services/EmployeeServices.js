import axios  from 'axios'


const EMOLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/v1/employees'

class EmployeeServices{
    getAllEmployees(){
        return axios.get(EMOLOYEE_BASE_REST_API_URL)
    }

    createEmployee(employee){
        return axios.post(EMOLOYEE_BASE_REST_API_URL,employee);
    }

    getEmployeeByID(employeeId){
        return axios.get(EMOLOYEE_BASE_REST_API_URL +'/'+employeeId);
    }

    updateEmployee(employeeId,employee){
        return axios.put(EMOLOYEE_BASE_REST_API_URL +'/'+employeeId,employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMOLOYEE_BASE_REST_API_URL +'/'+employeeId);
    }
}

// const employeee = new EmployeeServices();
export default new EmployeeServices;