import { useState, useEffect } from 'react';
import PostCard from '../components/PostCard';


function Posts() {

const [posts, setPosts] = useState([]);
const [loading, setLoading] = useState(true);
const [error, setError] = useState(null);

    useEffect(()=>  {
        const getResult = async () => {
            try {
            const result = await fetch(('http://localhost:8080/api/posts'));

            if(!result.ok) {
                throw new Error(`서버오류: ${result.status}`)
            }
            const data = await result.json();   // json -> js object로 변환
            setPosts(data);
        }  catch (err) {
            setError(err.message);
        }  finally {
            setLoading(false);
        }
        }

        getResult();
    }, []);


    if(loading) return <p>로딩중 ...</p>;
    if(error) return <p>에러발생: {error}</p>

    return (
        <>            
            <h2>글목록</h2>
            <div className="posts">
                {posts.map((post)=>(
                    <PostCard key={post.id} title={post.title} content={post.content} id={post.id}/>
                ))}
            </div>
        </>
    )
}

export default Posts;