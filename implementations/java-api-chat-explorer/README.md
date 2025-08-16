# API Chat Explorer (Java)

A minimal starting point for experimenting with AI-driven API calls in Java. This example
focuses on a simple tool that retrieves repository information from the public GitHub API.
It is intended as a foundation for larger experiments involving MCP-style tool invocation
and multiple APIs.

## Running

```bash
mvn -q package
java -cp target/api-chat-explorer-0.1.0.jar com.example.apichatexplorer.App
```

Then enter a repository in the form `owner/repo` (for example, `octocat/Hello-World`).

## Next Steps

- Add more API tools and expose them to an LLM via MCP.
- Wrap the command-line interaction with a chat interface.
- Implement logging and error handling for production use.
