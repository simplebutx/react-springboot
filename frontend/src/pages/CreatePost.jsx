import { useEffect, useState } from "react";

function CreatePost() {

const [title, setTitle] = useState('');
const [content, setContent] = useState('');


const handleSubmit = async () => {
    const response = await fetch('http://localhost:8080/api/posts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: title,
            content: content
        })})

    if(!response.ok) {
        alert('저장실패');
        return;
    }
    console.log('저장성공');
};

return (
    <>
        <p>글쓰기페이지</p>
        <form onSubmit={(e)=>e.preventDefault()}>
            <input placeholder="제목" value={title} onChange={(e)=>setTitle(e.target.value)}></input>   
            <textarea placeholder="내용" value={content} onChange={(e)=>setContent(e.target.value)}></textarea>
            <button type="button" onClick={handleSubmit}>글쓰기</button>
        </form>
    </>
)
    
}

export default CreatePost;