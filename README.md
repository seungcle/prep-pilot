#  PrepPilot - 취업준비생을 위한 스마트 블로그

**PrepPilot**는 취업준비생을 위한 AI 기반 블로그 플랫폼입니다.  
사용자가 직접 공부한 내용을 기록하면, AI가 자동으로 내용을 검토하고 퀴즈를 생성해주는 기능을 제공합니다.  
틀린 문제는 자동으로 오답노트에 저장되어, 다시 복습하며 실력을 향상시킬 수 있습니다.

---

##  주요 기능

| 기능 | 설명 |
|------|------|
|  블로그 작성 | 공부한 내용을 자유롭게 기록할 수 있습니다. |
|  AI 검토 | 작성한 내용을 AI가 분석하여 피드백 또는 문제를 자동 생성합니다. |
|  오답노트 | 틀린 문제는 자동 저장되며, 별도 페이지에서 복습할 수 있습니다. |
|  반복 학습 | 오답노트를 기반으로 다시 문제를 풀며 실력을 점검할 수 있습니다. |
|  태그/카테고리 | 글을 주제별로 분류하여 관리할 수 있습니다. |

---

##  기술 스택

- **Frontend**: React, SCSS, Zustand, Tanstack/React-Query
- **Backend**: Spring Boot, MySql  
- **AI**: OpenAI GPT API  
- **기타**: git, notion

---

## 역할 분담

- **Frontend**: 이수빈, 송승엽 
- **Backend**: 이승찬, 이혜성, 박지현  
- **AI**: 이승찬

##  프로젝트 실행 방법

```bash
# 1. 레포 클론
git clone https://github.com/seungcle/prep-pilot.git
cd prep-pilot

# 2. 프론트엔드 실행
cd client
npm install
npm run dev

# 3. 백엔드 실행
cd ../server
npm install
npm run dev
