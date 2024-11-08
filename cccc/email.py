import re

with open("input.txt", "r") as emails, open("op.txt", "w") as results:
    results.write("*** EMAIL HEADER DETAILS ***\n")
    for line in emails:
        if "From: " in line:
            address = re.findall(r'[\w\.-]+@[\w\.-]+', line)
            if address:
                results.write(f"\nFrom: {address[0]}")
        if "To: " in line:
            address = re.findall(r'[\w\.-]+@[\w\.-]+', line)
            if address:
                results.write("\nTo: " + ", ".join(address))
        if "Bcc: " in line:
            address = re.findall(r'[\w\.-]+@[\w\.-]+', line)
            if address:
                results.write("\nBcc: " + ", ".join(address))
        if "Date: " in line:
            results.write("\nDate: " + line.split("Date: ")[1].strip())
        if "Subject: " in line:
            results.write("\nSubject: " + line.split("Subject: ")[1].strip())

