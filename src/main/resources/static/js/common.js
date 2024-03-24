class SimpleHttpError extends Error {
    constructor(msg, data) {
        super(msg);
        this.data = data;
    }
}

(function () {

    const ResponseCode = {
        'OK': 'OK',
        'Invalid': 'Invalid',
        'Unavailable': 'Unavailable',
        'Timeout': 'Timeout',
        'Unknown': 'Unknown'
    };
    window.ResponseCode = ResponseCode;

    const preprocessResponse = async (response) => {
        let r;
        try {
            r = await response.json();
        } catch (e) {
            console.error(e);
            throw new SimpleHttpError('Invalid message received from server.\n' + ut.unexpectedErrorMessage);
        }
        if (!r) {
            r = {responseCode: ResponseCode.Unknown}
        }

        if (ResponseCode.OK !== r.responseCode) {
            throw new SimpleHttpError('', r);
        }
        return r;
    }

    window.ut = {
        unexpectedErrorMessage: 'Please retry again after minutes.',
        timeoutErrorMessage: 'Server response time exceeded.\nPlease try again.',
        fetchGet: async function (url, params) {
            const _url = new URL(location.href);
            _url.pathname = url;
            for (let i = 0, keys = Object.keys(params), l = keys.length; i < l; i++) {
                _url.searchParams.set(keys[i], params[keys[i]]);
            }
            return fetch(_url, {
                'Accept': 'application/json'
            }).then(preprocessResponse)
        },
        fetchPost: async function (url, params) {
            const data = new URLSearchParams();
            for (let i = 0, keys = Object.keys(params), l = keys.length; i < l; i++) {
                data.set(keys[i], params[keys[i]]);
            }

            return fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                },
                body: data
            }).then(preprocessResponse)
        },
        fetchMultiPart: async function (url, params) {
            const data = new FormData();
            for (let i = 0, keys = Object.keys(params), l = keys.length; i < l; i++) {
                data.set(keys[i], params[keys[i]]);
            }

            return fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                body: data
            }).then(preprocessResponse)
        },
        fetchJson: async function (url, params) {
            return fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(params)
            }).then(preprocessResponse)
        },
        // fetchForm: async function (url, form) {
        //     const allEls = form.querySelectorAll('input, select');
        //     const data = {};
        //     let hasFile = false;
        //     for (let i = 0, l = allEls.length; i < l; i++) {
        //         if ('INPUT' === allEls[i].tagName) {
        //             if (!hasFile && 'file' === allEls[i].type) {
        //                 hasFile = true;
        //             }
        //             data[allEls[i].name] = allEls[i].value;
        //         } else {
        //             // TODO 좀 나중에 구현
        //             // data[allEls[i].name] =
        //         }
        //     }
        //     if (hasFile) {
        //         return ut.fetchMultiPart(url, data);
        //     } else {
        //         return ut.fetchPost(url, data);
        //     }
        // }
    }

    window.onload = function () {
        if (window.documentReadyCallbacks && Array.isArray(window.documentReadyCallbacks)) {
            for (let i = 0, l = window.documentReadyCallbacks.length; i < l; i++) {
                const callback = window.documentReadyCallbacks.shift();
                if (typeof callback === 'function') {
                    callback();
                }
            }
        }
    };
})();