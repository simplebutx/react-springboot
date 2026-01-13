import { Link } from "react-router-dom";
import './Navbar.css'

function Navbar() {

    return (
        <>  
        <nav className="navbar">
            <Link to="/">Home</Link>
            <Link to="/posts">Posts</Link>
            <Link to="/posts/new">Write</Link>
        </nav>
        </>
    )
}

export default Navbar;