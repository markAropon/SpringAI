## Quick Start

1. Send requests to the chat endpoint:
   ```
   POST /chat?provider=ollama
   Body: {"message": "prompt here"}
   ```

## Supported Providers

- **ollama** (default): Uses local Ollama instance with llama3 model required to have ollama installed locally and llama 3 pulled

- **gemini**: Uses Google's Gemini

## Important Note

**Gemini API Issue**: The Gemini integration may not function if there are billing issues with Google Cloud account. There is a billing that needs to be activated before running this provider. PS. nagamit ko na po yung free trial ng account ko

**Error Explanation**: If you see a "Failed to generate content" error with "Your default credentials were not found", you need to set up Application Default Credentials (ADC) for authentication.
Need po gumawa and mag download ng keys sa google console

https://console.cloud.google.com/projectselector2/iam-admin/serviceaccounts?supportedpurview=project

then run tong command na to for windows

$env:GOOGLE_APPLICATION_CREDENTIALS="C:\path\to\key.json"

## API Usage Example

```bash
curl -X POST http://localhost:8080/chat?provider=ollama \
  -H "Content-Type: application/json" \
  -d '{"message": "What is artificial intelligence?"}'
```
