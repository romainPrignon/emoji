FROM python:3.11.1

WORKDIR /opt

COPY requirements.txt requirements.txt
RUN pip install --no-cache-dir -r requirements.txt

COPY src/ src/
RUN coconut --strict src/ dist/

ENTRYPOINT ["python", "/opt/dist/main.py"]