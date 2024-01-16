import {Link} from 'react-router-dom'
import { useAuth } from '../security/AuthContext'

function HeaderComponent() {
    const authContext = useAuth()



    return (
        
        <header className="border-bottom border-light border-5 mb-5 p-2">
            <div className="container">
                <div className="row">
                    <nav className="navbar navbar-expand-lg">
                        <a className="navbar-brand ms-2 fs-2 fw-bold text-black" href="https://github.com/junyong1111">PARK</a>
                        <div className="collapse navbar-collapse">
                            <ul className="navbar-nav">
                                <li className="nav-item">
                                    { <Link className="nav-link" to="/">Home</Link>}
                                    
                                </li>
                                <li className="nav-item">
                                    { <Link className="nav-link" to="/questions">Questions</Link>}                                    
                                </li>
                            </ul>
                        </div>
                        <ul className="navbar-nav">
                            <li className="nav-item">
                                { !authContext.isAuthenticated &&
                                    <Link className="nav-link" to="/login">Login</Link> }
                            </li>
                        </ul>
                        <ul className="navbar-nav"> 
                            <li className="nav-item">
                                { authContext.isAuthenticated &&
                                    <button className="nav-link" to="/logout" onClick={
                                        () =>{
                                            alert("로그아웃 되었습니다.")
                                            authContext.logout()
                                            window.location.reload("/")

                                        }
                                    }>Logout</button> }
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>

    )
}

export default HeaderComponent