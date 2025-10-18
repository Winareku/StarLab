---
banner: "https://images.unsplash.com/photo-1522252234503-e356532cafd5?ixlib=rb-4.1.0&q=85&fm=jpg&crop=entropy&cs=srgb&w=4800"
date: <%tp.date.now("YYYY-MM-DD")%>T<%tp.date.now("HH:mm")%>
tags:
  - Daily
cssclasses:
  - daily
  <% "- " + tp.date.now("dddd", 0, tp.file.title, "YYYYMMDD").toLowerCase() %>
---

# Daily Note
## <% tp.date.now("dddd, MMMM Do, YYYY", 0, tp.file.title, "YYYYMMDD") %>

***

### Notes

> [!tip] No notes found
> - Nothing to see here yet

***

### Tasks

> [!example] No tasks found
> - [ ] Nothing to see here yet