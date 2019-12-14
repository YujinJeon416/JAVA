# Apache Ant란
> 자바 기반의 빌드 자동화 도구

- 대체제로 `Maven`, `Gradle`이 있다.
- `Maven`에 비해 자유도가 높지만, 스크립트 재사용이 불가하여 같은 내용을 반본적으로 사용해야 한다는 단점이 있다.
## Another Neat Tool(Ant) 기본 설명
- 설정 파일의 형식은 `build.xml`
- 작업을 나누는 기본 단위는 `target`
    - 그 아래에 `Task`이 존재
    - `Task`들의 집합이 `target`


## `Ubuntu 18.04.3 LTS`에서 설치과정

1. java 버전에 맞는 `tar.gz`파일 다운
    - https://ant.apache.org/bindownload.cgi
2. 압축을 아무곳에나 푼뒤, 해당 위치에서 `/usr/local/`로 이동시켜준다.
    - `mv apache-ant-1.9.14 /usr/local/`
3. `user-specific`한 `~/.bashrc`에 
    ```
    export ANT_HOME=/usr/local/ant
    export PATH=$PATH:$ANT_HOME/bin
    ```을 넣어준다.
