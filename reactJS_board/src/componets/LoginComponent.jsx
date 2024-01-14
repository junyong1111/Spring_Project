import React from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import {goMainPage} from '../navi/QuestionNavi'
import { useNavigate } from 'react-router-dom';
import {useAuth} from '../security/AuthContext.js'
import 'bootstrap/dist/css/bootstrap.min.css'; // Bootstrap CSS 추가

export default function LoginComponent(){
  const authContext = useAuth()
  const navigator = useNavigate()
  
  const formik = useFormik({
    initialValues: {
      username: '',
      password: ''
    },
    validationSchema: Yup.object({
      username: Yup.string()
        .max(15, '15자 이내로 입력해주세요')
        .required('필수 입력 사항입니다'),
      password: Yup.string()
        .min(6, '비밀번호는 6자 이상이어야 합니다')
        .required('필수 입력 사항입니다'),
    }),
    onSubmit: values => {
        const User = {
            username : values.username,
            password : values.password,
        }
        console.log("로그인 요청")
        authContext.login(User)

        if (authContext.isAuthenticated === true){
          goMainPage(navigator)
        }
    },
  });
  
  

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card shadow">
            <div className="card-body">
              <h2 className="card-title text-center">로그인</h2>
              <form onSubmit={formik.handleSubmit}>
                <div className="form-group">
                  <label htmlFor="username">사용자 이름</label>
                  <input
                    className="form-control"
                    id="username"
                    name="username"
                    type="text"
                    onChange={formik.handleChange}
                    value={formik.values.username}
                  />
                  {formik.touched.username && formik.errors.username ? (
                    <div className="text-danger">{formik.errors.username}</div>
                  ) : null}
                </div>

                <div className="form-group">
                  <label htmlFor="password">비밀번호</label>
                  <input
                    className="form-control"
                    id="password"
                    name="password"
                    type="password"
                    onChange={formik.handleChange}
                    value={formik.values.password}
                  />
                  {formik.touched.password && formik.errors.password ? (
                    <div className="text-danger">{formik.errors.password}</div>
                  ) : null}
                </div>
                <div style={{textAlign:"center", marginTop:10}}>
                <button type="submit" className="Btn">로그인</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}