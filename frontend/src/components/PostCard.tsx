import './PostCard.css';

function PostCard({title, content, author} : any) {

    return (
            <div className="post-card">
                <h3 className="post-title">{title}</h3>
                    <p className="post-content">{content}</p>
                <span className="post-author">{author}</span>
            </div>
    )
}

export default PostCard;