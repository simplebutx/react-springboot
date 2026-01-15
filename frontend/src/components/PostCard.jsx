import Posts from '../pages/Posts';
import './PostCard.css';
import { Link } from 'react-router-dom';

function PostCard({title, content, author, id}) {

    return (
        <>
        <Link to={`/posts/${id}`} className='post-link'>
            <div className="post-card">
                <h3 className="post-title">{title}</h3>
                    <p className="post-content">{content}</p>
                <span className="post-author">{author}</span>
            </div>
        </Link>
        </>
    )
}

export default PostCard;