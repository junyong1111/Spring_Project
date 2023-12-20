import {useParams} from 'react-router-dom'
import { retrieveTodoApi, updateTodoApi, createTodoApi } from './api/TodoApiService'
import { useAuth } from '../security/AuthContext'
import { useEffect } from 'react'
import { useState } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import { useNavigate } from 'react-router-dom'
import moment from 'moment'

export default function TodoComponent(){
    const {id} = useParams()
    const authContext = useAuth()
    const username = authContext.username
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')
    const navigate = useNavigate()

    useEffect(
        () => retrieveTodos(),
        [id]
    )

    function retrieveTodos(){
        if(id !== -1){
            retrieveTodoApi(username, id)
            .then((response) => 
            {
                console.log(response)
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate)
            }
            
            )
            .catch((error) => console.log(error))
        }
    }

    function onSubmit(values){
        const todo = {
            id : id,
            username : username,
            description : values.description,
            targetDate : values.targetDate,
            done : false
        }
        if(id ===-1){
            createTodoApi(username, todo)
            .then((response) => console.log(response))
            .catch((error) => console.log(error))
            navigate('/todos')
        }
        else{
            updateTodoApi(username, id, todo)
            .then((response) => console.log(response))
            .catch((error) => console.log(error))
            navigate('/todos')
        }
        console.log(values)
        

    }

    function validate(values){
        let errors = {}
        if (values.description.length<=5){
            errors.description = 'Enter at least 5 character'
        }

        if (values.targetDate === null || values.targetDate ==='' || !moment(values.targetDate).isValid()){
            errors.targetDate = 'Enter a valid targetDate'
        }
        return errors

    }
    return(
        <div className="container">
            <h1>Todo Details</h1>
            <div>
                <Formik initialValues={ {description, targetDate} }
                enableReinitialize = {true}
                onSubmit={onSubmit}
                validate={validate}
                validateOnChange={false} // save 버튼을 누를 때만 검증
                validateOnBlur={false} // save 버튼을 누를 때만 검증
                
                >
                {
                    (props) => (
                        <Form>
                            <ErrorMessage
                                name='description'
                                component='div'
                                className='alert alert-warning'
                            />
                            <ErrorMessage
                                name='targetDate'
                                component='div'
                                className='alert alert-warning'
                            />
                            <fieldset className="form-group">
                                <label>description</label>
                                <Field type="text" className="form-control" name="description"/>
                            </fieldset>
                            <fieldset className="form-group">
                                <label>TargetDate</label>
                                <Field type="date" className="form-control" name="targetDate"/>
                            </fieldset>
                            <div>
                                <button className='btn btn-success m-5' type="submit">저장</button>
                            </div>
                        </Form>
                    )
                }
                </Formik>

            </div>
        </div>
    )
}