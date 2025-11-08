---
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

> [!tip] No notes found.
> - Nothing to see here yet.

***

### Tasks

> [!bug] No tasks found.
> - [?] Nothing to see here yet.