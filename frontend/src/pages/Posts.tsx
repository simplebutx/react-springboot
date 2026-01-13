import PostCard from '../components/PostCard';


function Posts() {
    const posts = [
    { id: 1, title: '첫 글', content: '내용 1', author: '홍길동' },
    { id: 2, title: '두 글', content: '내용 2', author: '김철수' },
    { id: 3, title: '세 글', content: '내용 3', author: '이영희' },
  ]

    return (
        <>
            <h2>글목록</h2>
            <div className="posts">
                {posts.map((post)=>(
                    <PostCard key={post.id} title={post.title} content={post.content} author={post.author}/>
                ))}
            </div>
        </>
    )
}

export default Posts;